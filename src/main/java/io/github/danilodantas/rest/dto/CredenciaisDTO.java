package io.github.danilodantas.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredenciaisDTO {

	private String login;
	private String senha;
}
