import Ember from 'ember';
import LoginRoute from './login';
import RSVP from 'rsvp';

const {
  inject: {
    service
  }
} = Ember;

export default  Ember.Route.extend({

  _suppliersService: service('suppliers-service'),
  _packageService: service('package-service'),

  model() {
    return RSVP.hash({
      services: this.get('_suppliersService').getAllServices() || [],
      packages: this.get('_packageService').getAllPackages() || []
    });
  }
});
