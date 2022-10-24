package com.devandre.supportportalbackend.enumeration;

import static com.devandre.supportportalbackend.constant.Authority.*;

/**
 * @author Andre Gallegos
 * @create 2022-09-29 15:09
 **/
public enum Role {

    ROLE_USER(USER_AUTHORITIES),
    ROLE_HR(HR_AUTHORITIES),
    ROLE_MANAGER(MANAGER_AUTHORITIES),
    ROLE_ADMIN(ADMIN_AUTHORITIES),
    ROLE_SUPER_ADMIN(SUPER_ADMIN_AUTHORITIES);

    private String[] authorities;

    Role(String... authorities) {
        this.authorities = authorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }
}
