import Ember from 'ember';

const multiply = (params) => Number((params[0] * params[1]).toFixed(2));
export default Ember.Helper.helper(multiply);
