package com.kryptopass.domain.entity

sealed class UseCaseException(cause: Throwable) : Throwable(cause) {

    class LaunchException(cause: Throwable) : UseCaseException(cause)

    class CompanyInfoException(cause: Throwable) : UseCaseException(cause)

    class UnknownException(cause: Throwable) : UseCaseException(cause)

    companion object {

        fun createFromThrowable(throwable: Throwable): UseCaseException {
            return if (throwable is UseCaseException) throwable else UnknownException(throwable)
        }
    }
}