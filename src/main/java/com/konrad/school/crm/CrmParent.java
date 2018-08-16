package com.konrad.school.crm;

import com.konrad.school.validation.FieldMatch;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@FieldMatch.List({
        @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class CrmParent {
}
