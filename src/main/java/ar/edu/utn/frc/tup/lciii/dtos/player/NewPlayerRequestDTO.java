package ar.edu.utn.frc.tup.lciii.dtos.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewPlayerRequestDTO {

    @NotNull
    @JsonProperty("user_name")
    private String userName;

    @NotNull
    private String password;


    // !!TODO: Validar que email tenga un formato valido
    @NotNull
    @Email(message = "The email format it's not valid")
    private String email;

}
