package com.yildirimomer01.ewa.util

/**
 * mocking annotation class for mockable api functions
 * to be able to use mock responses,
 * include mock json file into assets folder and annotate the function as below
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Mockable(val fileName: String, val mockEnabled: Boolean)
