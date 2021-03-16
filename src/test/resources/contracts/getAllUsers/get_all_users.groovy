package contracts.getAllUsers

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Get all available Users")
    request{
        method("GET")
        urlPath("/users")
    }
    response {
        status OK()
        headers {
            header 'Content-Type':'application/json'
        }
        body(file("response.json"))
    }
}