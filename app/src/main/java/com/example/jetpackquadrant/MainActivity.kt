package com.example.jetpackquadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackquadrant.ui.theme.JetpackQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.weight(1F)) {
            QuadrantItem(
                heading = stringResource(id = R.string.text_composable_heading),
                body = stringResource(id = R.string.text_composable_body),
                bgColor = colorResource(id = R.color.quadrant_1),
                modifier = Modifier.weight(1F)
            )
            QuadrantItem(
                heading = stringResource(id = R.string.image_composable_heading),
                body = stringResource(id = R.string.image_composable_body),
                bgColor = colorResource(id = R.color.quadrant_2),
                modifier = Modifier.weight(1F)
            )
        }
        Row(modifier = Modifier.weight(1F)) {
            QuadrantItem(
                heading = stringResource(id = R.string.row_composable_heading),
                body = stringResource(id = R.string.row_composable_body),
                bgColor = colorResource(id = R.color.quadrant_3),
                modifier = Modifier.weight(1F)
            )
            QuadrantItem(
                heading = stringResource(id = R.string.column_composable_heading),
                body = stringResource(id = R.string.column_composable_body),
                bgColor = colorResource(id = R.color.quadrant_4),
                modifier = Modifier.weight(1F)
            )
        }
    }
}

@Composable
fun QuadrantItem(heading: String, body: String, bgColor: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = bgColor)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = heading,
                modifier = Modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold
            )
            Text(text = body, textAlign = TextAlign.Justify)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantItemPreview() {
    JetpackQuadrantTheme {
        QuadrantItem(
            heading = stringResource(id = R.string.row_composable_heading),
            body = stringResource(id = R.string.row_composable_body),
            bgColor = colorResource(id = R.color.quadrant_1)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantPreview() {
    JetpackQuadrantTheme {
        Quadrant()
    }
}
