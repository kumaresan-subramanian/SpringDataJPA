package com.example.data.jpa.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
		description = "user dto"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Long id;
	
	@Schema(
			description = "user firstName"
	)
	@NotEmpty(message = "user firstName should not be null or empty")
	private String firstName;
	
	@Schema(
			description = "user lastname"
	)
	@NotEmpty(message = "user lastName should not be null or empty")
	private String lastName;
	
	@Schema(
			description = "user email"
	)
	@NotEmpty(message = "user email should not be null or empty")
	@Email(message = "user email should  be valid")
	private String email;
	
}
