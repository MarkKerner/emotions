/**
 * Created by Mark on 8.05.2016.
 */
import {Component, OnInit} from 'angular2/core';

import {Emotion} from "../model/emotion";
import {ProfileService} from "./profile.service";
import {EmotionSelectedComponent} from "./emotion_selected.component";

let template = require('./profile.html');
let styles = require('./profile.css');

@Component({
  selector: 'profile',
  template: template,
  styles: [styles],
  providers: [ProfileService],
  directives: [EmotionSelectedComponent]
})
export class Profile implements OnInit {

  emotions:Emotion[];
  selectedEmotion:Emotion;

  constructor(private _profileService:ProfileService) {
  }

  ngOnInit() {
    this.getEmotions();
  }

  getEmotions() {
    this._profileService.getActiveEmotions().then(emotions => this.emotions = emotions);
  }

  selectEmotion(emotion:Emotion) {
    this.selectedEmotion = emotion;
  }

  closeEmotion() {
    this.selectedEmotion = null;
  }
}
