/**
 * Created by Mark on 8.05.2016.
 */
import {Component, OnInit} from 'angular2/core';
import {Emotion} from "../model/emotion";
import {ProfileService} from "./profile.service";

let template = require('./profile.html');
let styles = require('./profile.css');

@Component({
  template: template,
  styles: [styles],
  providers: [ProfileService]
})
export class Profile implements OnInit {

  emotions:Emotion[];
  selectedEmotion:Emotion;

  constructor(private  _profileService:ProfileService) {
  }

  getEmotions() {
    this._profileService.getActiveEmotions().then(emotions => this.emotions = emotions);
  }

  ngOnInit() {
    this.getEmotions();
  }


}
