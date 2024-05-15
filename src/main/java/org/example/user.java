package org.example;

public class user {
    /*
        Atributos: nombre de usuario, contraseña, rol.
        Métodos: getters y setters para los atributos, método para verificar la contraseña.
    */
    private String userName;
    private String password;
    private String role;

    public user(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }
}
