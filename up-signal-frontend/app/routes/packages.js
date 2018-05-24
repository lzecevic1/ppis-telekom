import Ember from 'ember';

const {
  inject: {
    service
  }
} = Ember;

export default Ember.Route.extend({
  _packageService: service('package-service'),
  session: Ember.inject.service(),
  model() {
    return this.get('_packageService').getAllPackages() || {};
  },

  actions: {

  }
});