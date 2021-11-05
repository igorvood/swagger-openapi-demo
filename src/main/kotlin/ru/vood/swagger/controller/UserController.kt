package ru.vood.swagger.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RestController
import ru.vood.swagger.controller.UserApi
import org.springframework.web.bind.annotation.GetMapping
import java.util.*

@Tag(name = "User", description = "The User API")
@RestController
class UserController {
    @get:GetMapping("/users")
    @get:ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "Found the users",
            content = [Content(
                mediaType = "application/json",
                array = ArraySchema(
                    schema = Schema(
                        implementation = UserApi::class
                    )
                )
            )]
        )]
    )
    @get:Operation(summary = "Gets all users", tags = ["user"])
    val users: List<UserApi>
        get() = listOf(UserApi("asd", 23))
}