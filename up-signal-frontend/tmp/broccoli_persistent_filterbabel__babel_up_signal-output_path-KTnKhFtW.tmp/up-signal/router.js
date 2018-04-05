define('up-signal/router', ['exports', 'up-signal/config/environment'], function (exports, _environment) {
  'use strict';

  Object.defineProperty(exports, "__esModule", {
    value: true
  });


  var Router = Ember.Router.extend({
    location: _environment.default.locationType,
    rootURL: _environment.default.rootURL
  });

  Router.map(function () {
    this.route('homepage');
    this.route('login');
    this.route('about-us');
    this.route('services');
    this.route('packages');
  });

  exports.default = Router;
});