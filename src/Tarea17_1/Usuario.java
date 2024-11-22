package Tarea17_1;

class Usuario {
    private String nombre;
    private String apellido;
    private String telefono;
    private String contraseña;

    public Usuario(String nombre, String apellido, String telefono, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getContrasena() {
        return contraseña;
    }
}

