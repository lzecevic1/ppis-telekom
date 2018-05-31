import Ember from 'ember';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Route.extend({

    _suppliersService: service('suppliers-service'),
    session: Ember.inject.service('session'),
    beforeModel(){
        if(!this.get('session.isAuthenticated'))
            this.transitionTo('all-services');
        if(this.get('session.data.authenticated.user.role.name') == "SUPPLIER")
            this.transitionTo('all-services');
    },
    model(params) {
        return this.get('_suppliersService').getService(params.id);
    }
});
