package com.konrad.school.crm;

import com.konrad.school.validation.FieldMatch;
import com.konrad.school.validation.ValidEmail;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@FieldMatch.List({
        @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class CrmParent {

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;
    private String mobilePhone;
    @ValidEmail
    private String mail;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String userName;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String password;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String matchingPassword;

    public CrmParent() {
    }
}
