package com.arindam.kotlin.x

import com.arindam.kotlin.x.Medium.EMAIL
import com.arindam.kotlin.x.Medium.SMS
import com.arindam.kotlin.x.VisaDecision.APPROVED
import com.arindam.kotlin.x.VisaDecision.REJECTED

/**
 * Infix functions can lay the foundations for building 🏛️ interesting DSLs in Kotlin.
 *
 * Created by Arindam Karmakar on 7/8/19.
 */

enum class VisaDecision { APPROVED, REJECTED }
enum class Medium { EMAIL, SMS }

data class EntryClearanceOfficer(val firstName: String, val lastName: String)
data class VisaApplication(val applicantName: String)

infix fun EntryClearanceOfficer.process(application: VisaApplication): VisaDecision {
    val officerFullName = "${this.firstName} ${this.lastName}"
    return if (application.applicantName == "Arindam") {
        println("$officerFullName processing ${application.applicantName}'s application #${application.hashCode()}")
        APPROVED
    } else {
        println("Sorry, $officerFullName is rejected ${application.applicantName}'s application #${application.hashCode()}")
        REJECTED
    }
}

infix fun VisaDecision.sendIntimationVia(medium: Medium) {
    when (medium) {
        EMAIL -> println("Sending intimation via $medium")
        SMS -> println("Retrying again via $medium")
    }
}

fun main() {
    val johnDoe = EntryClearanceOfficer("John", "Doe")
    val myVisaApplication = VisaApplication("Mary")

    val decision = johnDoe process myVisaApplication
    decision sendIntimationVia if (decision == APPROVED) EMAIL else SMS

    println(decision) // > REJECTED
}
