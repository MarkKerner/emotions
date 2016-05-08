/**
 * Created by Mark on 8.05.2016.
 */
/*import {Injectable} from 'angular2/core';
 import {HEROES} from './mock-heroes';
 import {Hero} from './hero';

 @Injectable()
 export class HeroService {
 getHeroes() {
 return Promise.resolve(HEROES);
 }

 getHero(id: number) {
 return Promise.resolve(HEROES).then(
 heroes => heroes.filter(hero => hero.id === id)[0]
 );
 }

 //Example method for slow connection
 getHeroesSlowly() {
 return new Promise<Hero[]>(resolve =>
 setTimeout(()=>resolve(HEROES), 2000) // 2 seconds
 );
 }
 }*/

import {Injectable} from 'angular2/core';
import {Emotion} from '../model/emotion';

var EMOTIONS:Emotion[] = [
  {"id": 1, "name": "Love"},
  {"id": 2, "name": "Happiness"},
  {"id": 3, "name": "Sadness"},
  {"id": 4, "name": "Satisfaction"},
  {"id": 5, "name": "Anger"}
]

@Injectable()
export class ProfileService {

  getActiveEmotions() {
    return Promise.resolve(EMOTIONS);
  }
}
