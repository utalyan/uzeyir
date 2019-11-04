package com.uzeyir.booksales.dto;

import com.uzeyir.booksales.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "user")
public class UserDto {

    private Long id;

    @NotBlank(message = "İsim Boş olamaz.")
    private String name;
    private Address address;

    @NotBlank(message = "Mail Adres Girilmeli.")
    @Email(message = "Hatalı e-mail")
    private String mailAddress;

}
