import {Component} from 'angular2/core';
import {CORE_DIRECTIVES} from 'angular2/common';
import {Http, Headers} from 'angular2/http';
import {AuthHttp} from 'angular2-jwt';
import {Router, RouteConfig, ROUTER_DIRECTIVES} from 'angular2/router';

import {Profile} from '../profile/profile';

let styles = require('./home.css');
let template = require('./home.html');


@RouteConfig([
  {path: '/profile', component: Profile, name: 'Profile', useAsDefault: true}
])

@Component({
  selector: 'home',
  directives: [CORE_DIRECTIVES, ROUTER_DIRECTIVES],
  template: template,
  styles: [styles]
})
export class Home {
  jwt:string;
  decodedJwt:string;
  response:string;
  api:string;

  constructor(public router:Router, public http:Http, public authHttp:AuthHttp) {
    this.jwt = localStorage.getItem('jwt');
    this.decodedJwt = this.jwt && window.jwt_decode(this.jwt);
  }

  logout() {
    localStorage.removeItem('jwt');
    this.router.parent.navigateByUrl('/login');
  }

  callAnonymousApi() {
    this._callApi('Anonymous', 'http://localhost:3001/api/random-quote');
  }

  callSecuredApi() {
    this._callApi('Secured', 'http://localhost:3001/api/protected/random-quote');
  }

  _callApi(type, url) {
    this.response = null;
    if (type === 'Anonymous') {
      // For non-protected routes, just use Http
      this.http.get(url)
        .subscribe(
          response => this.response = response.text(),
          error => this.response = error.text()
        );
    }
    if (type === 'Secured') {
      // For protected routes, use AuthHttp
      this.authHttp.get(url)
        .subscribe(
          response => this.response = response.text(),
          error => this.response = error.text()
        );
    }
  }
}
