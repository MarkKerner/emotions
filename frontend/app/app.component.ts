import { Component } from 'angular2/core';
import { RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS } from 'angular2/router';

import {ProfileComponent} from './profile.component';

@Component({
    selector: 'feel-app',
    templateUrl: 'app/html/app.component.html',
    styleUrls: ['app/css/app.component.css'],
	directives: [ProfileComponent]
})
export class AppComponent { }
