package com.example.Registration.Entites;



import com.example.Registration.Enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table()
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column (unique = true)
    private String gmail;
    @Column(nullable = false)
    private String password;

}
