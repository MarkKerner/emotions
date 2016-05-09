/**
 * Created by Mark on 9.05.2016.
 */

import {Component, Input, Output, EventEmitter} from 'angular2/core';
import {RouteParams} from 'angular2/router';

import {Emotion} from "../model/emotion";
import {ProfileService} from "./profile.service";

let template = require('./emotion_selected.component.html');
let styles = require('./emotion_selected.component.css');

@Component({
  selector: 'emotion-selected',
  template: template,
  styles: [styles]
})

export class EmotionSelectedComponent {
  @Input()
  emotion:Emotion;
  @Output()
  closeRequest = new EventEmitter<any>();

  constructor(private _profileService:ProfileService) {
  }

  close() {
    this.closeRequest.emit(null);
  }
}
