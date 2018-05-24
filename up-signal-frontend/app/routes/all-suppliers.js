import Ember from 'ember';
const {
  inject: {
    service
  }
} = Ember;

export default Ember.Route.extend({
  _supplierService: service('suppliers-service'),
  _contractService: service('contract-service'),
  _ratingService: service('rating-service'),
  session: Ember.inject.service('session'),

  beforeModel(transition)
  {
    if(!this.get('session.isAuthenticated')) {
      this.transitionTo('login');
    }
  },
  model() {
    return Ember.RSVP.hash({
      supplier: this.get('_supplierService').getAllSuppliers() || {},
      rating: this.get('_ratingService').createRating()
    });

  },

  actions: {

  createContract: function(id) {
    this.get('_contractService').setCurrentSupplier(id);
    this.transitionTo('new-contract', id);
  }

  }
});


