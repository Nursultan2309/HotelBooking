package com.example.Department.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl //implements USerDetails
{
//    private static final long serialVersionUID = 1L;
//    private Long id;
//    private String username;
//    private String email;
//    @JsonIgnore
//    private String password;
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public UserDetailsImpl(Long id, String username, String email, String password,
//                           Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//    public static UserDetailsImpl build(User user) {
//        List<GrantedAuthority> authorityList = new ArrayList<>();
//        authorityList.add(new SimpleGrantedAuthority(user.getRole().getRole().toString()));
//
//        AccountServers accountServers = new AccountServersImpl();
//        return new UserDetailsImpl(
//                user.getId(),
//                user.getName(),
//                user.getEmail(),
//                accountServers.findByUser(UserMapper.INSTANCE.toDto(user)).getPassword(),
//                authorityList);
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}

}
