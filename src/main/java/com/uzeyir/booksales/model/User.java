package com.uzeyir.booksales.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "user")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String name;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;

    @NotBlank(message = "Mail Adres Girilmeli.")
    @Email(message = "Hatalı e-mail")
    private String mailAddress;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    private Set<Orders> orders = new HashSet<>();


}
