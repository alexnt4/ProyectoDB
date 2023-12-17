package org.example.modelo;

public class Usuario {

        private String idUsuario;
        private String nombreUsuario;
        private String passwordUsuario;
        private String tipoUsuario;

        public Usuario() {

        }

        public Usuario(String idUsuario, String nombreUsuario, String passwordUsuario, String tipoUsuario) {
            this.idUsuario = idUsuario;
            this.nombreUsuario = nombreUsuario;
            this.passwordUsuario = passwordUsuario;
            this.tipoUsuario = tipoUsuario;
        }

        public String getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(String idUsuario) {
            this.idUsuario = idUsuario;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public void setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }


        public String getPasswordUsuario() {
            return passwordUsuario;
        }


        public void setPasswordUsuario(String passwordUsuario) {
            this.passwordUsuario = passwordUsuario;
        }


        public String getTipoUsuario() {
            return tipoUsuario;
        }


        public void setTipoUsuario(String tipoUsuario) {
            this.tipoUsuario = tipoUsuario;
        }
}
