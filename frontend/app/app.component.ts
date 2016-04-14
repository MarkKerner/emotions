import { Component } from 'angular2/core';
import { RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS } from 'angular2/router';

import {ProfileComponent} from './profile.component';
import {LoginComponent} from './login.component';



@RouteConfig([{
	path: '/profile',
	name: 'Profile',
		component: ProfileComponent,
		useAsDefault: true
	},
	{
		path: '/login',
		name: 'Login',
		component: LoginComponent
	}
])

@Component({
    selector: 'feel-app',
    templateUrl: 'app/html/app.component.html',
    styleUrls: ['app/css/app.component.css'],
	directives: [ROUTER_DIRECTIVES],
	providers: [
		ROUTER_PROVIDERS
	]
})

export class AppComponent { }
