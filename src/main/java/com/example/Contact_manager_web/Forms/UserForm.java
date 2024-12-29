package com.example.Contact_manager_web.Forms;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserForm {

    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String about;

}
