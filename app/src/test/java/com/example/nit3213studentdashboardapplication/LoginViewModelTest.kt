package com.example.nit3213studentdashboardapplication

import org.junit.Assert.*
import org.junit.Test

class LoginViewModelTest {

    private val viewModel = LoginViewModel()

    @Test
    fun validLogin_returnsTrue() {
        val result = viewModel.isValidLogin("Susam", "s12345678")
        assertTrue(result)
    }

    @Test
    fun emptyUsername_returnsFalse() {
        val result = viewModel.isValidLogin("", "s12345678")
        assertFalse(result)
    }

    @Test
    fun invalidPasswordFormat_returnsFalse() {
        val result = viewModel.isValidLogin("Susam", "12345678")
        assertFalse(result)
    }
}
