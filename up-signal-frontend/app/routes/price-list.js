import Ember from 'ember';
import LoginRoute from './login';

const {
  inject: {
    service
  }
} = Ember;

export default LoginRoute.extend({
  beforeModel(transition)
  {
    if(!this.get('session.isAuthenticated')) {
      this.transitionTo('login');
    }
    else if(this.get('session.data.authenticated.user.role.name') == "SERVICER")
      this.transitionTo('homepage');
  },
  actions: {
   }
});
