package com.qa.cineverse.dto;

import com.qa.cineverse.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class UserDTOTest {

    private UserDTO userDTO;
    private UserDTO other;

    private User user;
    private User userOther;

    @Before
    public void setUp() {
        User user = new User();
        user.setForename("Boyman");
        user.setSurname("Chris");
        user.setUsername("Dudeman");
        user.setPassword("root");
        user.setMatchingPassword("root");
        user.setActive(true);
        user.setEmail("test@aol.com");
        user.setRoles("ROLE_USER");

        User userOther = new User();
        userOther.setForename("Braff");
        userOther.setSurname("Zach");
        userOther.setUsername("BraffLoverXx");
        userOther.setPassword("ratty");
        userOther.setMatchingPassword("ratty");
        userOther.setActive(false);
        userOther.setEmail("braffloverxx@yahoo.com");
        userOther.setRoles("ROLE_ADMIN");

        userDTO = new UserDTO(user);
        other = new UserDTO(userOther);
    }

    @Test
    public void userDTOForenameNullButOtherForenameNotNull() {
        userDTO.setForename(null);
        assertFalse(userDTO.equals(other));
    }

    @Test
    public void userDTOForenameNotEqual() {
        userDTO.setForename("Boyman");
        assertFalse(userDTO.equals(other));
    }

    @Test
    public void userDTOSurnameNullButOtherForenameNotNull() {
        userDTO.setSurname(null);
        assertFalse(userDTO.equals(other));
    }

    @Test
    public void userDTOSurnameNotEqual() {
        userDTO.setSurname("Chris");
        assertFalse(userDTO.equals(other));
    }


}
