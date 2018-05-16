import Ember from 'ember';
import Base from 'ember-simple-auth/authenticators/base';

const {RSVP: { Promise }} = Ember;

export default Base.extend({
    telekomHttp: Ember.inject.service('telekom-http'),

    restore(data) {
        return new Promise((resolve, reject) => {
            if (!Ember.isEmpty(data.token)) {
                resolve(data);
            } else {
                reject();
            }
        });
    },

    authenticate(credentials, callback) {
        return this.get('telekomHttp').post('login', credentials, (resp) => {
            if (callback) {
                callback(resp);
            }

            return resp;
        });
    },

    invalidate(data) {
        return Promise.resolve(data);
    }
});
