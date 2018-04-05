import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('homepage');
  this.route('login');
  this.route('about-us');
  this.route('services');
  this.route('packages');
});

export default Router;
