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
  this.route('packages');
  this.route('new-service');
  this.route('new-supplier');
  this.route('all-services');
  this.route('all-suppliers');
  this.route('news');
  this.route('new-contract', { path: '/:id/new-contract'});
  this.route('all-contracts');
  this.route('price-list');
  this.route('new-package');
});

export default Router;
