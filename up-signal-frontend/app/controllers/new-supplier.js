import Ember from 'ember';

export default Ember.Controller.extend({
  actions: {
    selectCategory: function (value) {
      this.set('model.category', value);
    },
  }
  });
