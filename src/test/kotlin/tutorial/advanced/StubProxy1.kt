package tutorial.advanced

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.thisIs
import shirates.core.proxy.dataPattern
import shirates.core.proxy.getDataPattern
import shirates.core.proxy.resetDataPattern
import shirates.core.vision.driver.branchextension.stubNot
import shirates.core.vision.testcode.VisionTest

class StubProxy1 : VisionTest() {

    @Test
    @Order(10)
    fun stubProxy1() {

        scenario {
            case(1) {
                condition {
                    stubNot {
                        SKIP_SCENARIO("Stub required.")
                    }
                    resetDataPattern()
                }.expectation {
                    getDataPattern("CustomerList")
                        .thisIs("default")
                }
            }
            case(2) {
                condition {
                    dataPattern("CustomerList", "customer/01")
                }.expectation {
                    getDataPattern("CustomerList")
                        .thisIs("customer/01")
                }
            }
        }

    }
}