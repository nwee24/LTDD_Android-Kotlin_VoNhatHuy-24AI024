package com.example.lab8

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Bước 1. Tạo class điều hướng [cite: 8]
sealed class Screen(val rout: String) {
    object Home : Screen("home")
    object Signin : Screen("signin")
    object Signup : Screen("signup")
}

// Bước 2. Tạo hàm Mynavigation() [cite: 9, 10, 11]
@Composable
fun Mynavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Signin.rout // Màn hình mặc định là Đăng nhập [cite: 10]
    ) {
        composable(Screen.Signin.rout) {
            // Đảm bảo hàm SignInScreen đã được định nghĩa trong file Screen.kt [cite: 10]
            SignInScreen(navController = navController)
        }
        composable(Screen.Home.rout) {
            // Đảm bảo hàm HomeScreen đã được định nghĩa trong file Screen.kt [cite: 10]
            HomeScreen(navController = navController)
        }
        composable(Screen.Signup.rout) {
            // Đảm bảo hàm SignUpScreen đã được định nghĩa trong file Screen.kt [cite: 11]
            SignUpScreen(navController = navController)
        }
    }
}