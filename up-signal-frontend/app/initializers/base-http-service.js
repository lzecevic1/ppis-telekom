export function initialize(application) {
    application.inject('route', 'base-http-service', 'service:base-http-service');
    application.inject('controller', 'base-http-service', 'service:base-http-service');
    application.inject('component', 'base-http-service', 'service:base-http-service');
  }
  
  export default {
    name: 'base-http-service',
    initialize
  };
  