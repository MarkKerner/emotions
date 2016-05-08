import {View, Component} from 'angular2/core';
import {Location, RouteConfig, RouterLink, Router} from 'angular2/router';

import {LoggedInRouterOutlet} from './LoggedInOutlet';
import {Home} from '../home/home';
import {Login} from '../login/login';
import {Signup} from '../signup/signup';

let template = require('./app.html');

@RouteConfig([
  { path: '/', redirectTo: ['/Home'] },
  { path: '/home/...', component: Home, as: 'Home' },
  { path: '/login', component: Login, as: 'Login' },
  { path: '/signup', component: Signup, as: 'Signup' }
])

@Component({
  selector: 'feel-app',
  template: template,
  directives: [ LoggedInRouterOutlet ]
})
export class App {
  constructor(public router: Router) {
  }
}
