import axios from "axios";

class AuthenticationService {
    login(username, password) {
        return axios
          .post('http://localhost:8080/api/v1/login', {
            username,
            password
          })
          .then(response => {
            if (response.data.idToken) {
                sessionStorage.setItem('token', response.data.idToken);
            }
          })
          .catch(err => {
                console.error('There was an error!', err);
          });
      }
}

export default new AuthenticationService()