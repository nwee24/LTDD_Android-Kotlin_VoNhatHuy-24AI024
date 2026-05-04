package com.example.tip_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.util.Locale // Thêm import này
import kotlin.math.ceil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Sử dụng MaterialTheme để đảm bảo màu sắc và font chữ chuẩn
            MaterialTheme {
                TipCalculatorApp()
            }
        }
    }
}

@Composable
fun TipCalculatorApp() {
    // STATE
    var billAmount by remember { mutableStateOf("") }
    var tipPercent by remember { mutableStateOf(15f) }
    var roundUp by remember { mutableStateOf(false) }

    // Tính toán tip ngay trong composition
    val tip = calculateTip(billAmount, tipPercent, roundUp)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        // Thêm verticalScroll để tránh crash/lỗi hiển thị khi bàn phím hiện lên
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Tip Calculator",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.align(Alignment.Start)
            )

            OutlinedTextField(
                value = billAmount,
                onValueChange = { input ->
                    // Chỉ cho phép nhập số và tối đa một dấu chấm
                    if (input.all { it.isDigit() || it == '.' }) {
                        billAmount = input
                    }
                },
                label = { Text("Bill Amount") },
                prefix = { Text("$") }, // Thêm ký hiệu $ cho đẹp
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Tip Percentage")
                Text("${tipPercent.toInt()}%")
            }

            Slider(
                value = tipPercent,
                onValueChange = { tipPercent = it },
                valueRange = 0f..30f,
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Round Up Tip", modifier = Modifier.weight(1f))
                Switch( // Dùng Switch trông sẽ hiện đại hơn Checkbox ở đây
                    checked = roundUp,
                    onCheckedChange = { roundUp = it }
                )
            }

            Divider() // Đường kẻ phân cách

            Text(
                text = "Tip Amount: $tip",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

fun calculateTip(
    billAmount: String,
    tipPercent: Float,
    roundUp: Boolean
): String {
    // Xử lý an toàn khi chuỗi trống hoặc không đúng định dạng số
    val amount = billAmount.toDoubleOrNull() ?: 0.0
    var tip = amount * tipPercent / 100

    if (roundUp) {
        tip = ceil(tip)
    }

    // Quan trọng: Ép buộc sử dụng Locale.US để dùng dấu chấm thập phân, tránh crash ở các vùng dùng dấu phẩy
    return "$" + String.format(Locale.US, "%.2f", tip)
}