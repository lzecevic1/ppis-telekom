import Ember from 'ember';

export default Ember.Controller.extend({
  actions: {
    selectType: function (value) {
      this.set('model.type', value);
    },
  }
});
