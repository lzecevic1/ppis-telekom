'use strict';

define('up-signal/tests/app.lint-test', [], function () {
  'use strict';

  QUnit.module('ESLint | app');

  QUnit.test('app.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'app.js should pass ESLint\n\n');
  });

  QUnit.test('authenticators/application.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'authenticators/application.js should pass ESLint\n\n');
  });

  QUnit.test('components/create-contract.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'components/create-contract.js should pass ESLint\n\n');
  });

  QUnit.test('components/info-list-item.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'components/info-list-item.js should pass ESLint\n\n');
  });

  QUnit.test('components/main-navigation.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'components/main-navigation.js should pass ESLint\n\n');
  });

  QUnit.test('controllers/all-services.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'controllers/all-services.js should pass ESLint\n\n');
  });

  QUnit.test('controllers/all-suppliers.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'controllers/all-suppliers.js should pass ESLint\n\n30:28 - \'id\' is defined but never used. (no-unused-vars)\n34:37 - \'rating\' is defined but never used. (no-unused-vars)');
  });

  QUnit.test('controllers/login.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'controllers/login.js should pass ESLint\n\n');
  });

  QUnit.test('controllers/new-service.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'controllers/new-service.js should pass ESLint\n\n');
  });

  QUnit.test('controllers/new-supplier.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'controllers/new-supplier.js should pass ESLint\n\n');
  });

  QUnit.test('controllers/services.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'controllers/services.js should pass ESLint\n\n');
  });

  QUnit.test('controllers/suppliers.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'controllers/suppliers.js should pass ESLint\n\n');
  });

  QUnit.test('helpers/diff.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/diff.js should pass ESLint\n\n');
  });

  QUnit.test('helpers/eq.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/eq.js should pass ESLint\n\n');
  });

  QUnit.test('initializers/base-http-service.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'initializers/base-http-service.js should pass ESLint\n\n');
  });

  QUnit.test('models/base-model.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'models/base-model.js should pass ESLint\n\n');
  });

  QUnit.test('models/user.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'models/user.js should pass ESLint\n\n');
  });

  QUnit.test('resolver.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'resolver.js should pass ESLint\n\n');
  });

  QUnit.test('router.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'router.js should pass ESLint\n\n');
  });

  QUnit.test('routes/about-us.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'routes/about-us.js should pass ESLint\n\n');
  });

  QUnit.test('routes/all-services.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'routes/all-services.js should pass ESLint\n\n');
  });

  QUnit.test('routes/all-suppliers.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'routes/all-suppliers.js should pass ESLint\n\n12:15 - \'transition\' is defined but never used. (no-unused-vars)');
  });

  QUnit.test('routes/homepage.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'routes/homepage.js should pass ESLint\n\n');
  });

  QUnit.test('routes/index.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'routes/index.js should pass ESLint\n\n');
  });

  QUnit.test('routes/login.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'routes/login.js should pass ESLint\n\n6:13 - \'transition\' is defined but never used. (no-unused-vars)');
  });

  QUnit.test('routes/new-contract.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'routes/new-contract.js should pass ESLint\n\n17:15 - \'transition\' is defined but never used. (no-unused-vars)');
  });

  QUnit.test('routes/new-service.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'routes/new-service.js should pass ESLint\n\n18:15 - \'transition\' is defined but never used. (no-unused-vars)');
  });

  QUnit.test('routes/new-supplier.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'routes/new-supplier.js should pass ESLint\n\n17:15 - \'transition\' is defined but never used. (no-unused-vars)');
  });

  QUnit.test('routes/news.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'routes/news.js should pass ESLint\n\n');
  });

  QUnit.test('routes/packages.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'routes/packages.js should pass ESLint\n\n');
  });

  QUnit.test('routes/services.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'routes/services.js should pass ESLint\n\n');
  });

  QUnit.test('routes/suppliers.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'routes/suppliers.js should pass ESLint\n\n15:15 - \'transition\' is defined but never used. (no-unused-vars)');
  });

  QUnit.test('services/base-http-service.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'services/base-http-service.js should pass ESLint\n\n');
  });

  QUnit.test('services/contract-service.js', function (assert) {
    assert.expect(1);
    assert.ok(false, 'services/contract-service.js should pass ESLint\n\n24:2 - Mixed spaces and tabs. (no-mixed-spaces-and-tabs)');
  });

  QUnit.test('services/suppliers-service.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'services/suppliers-service.js should pass ESLint\n\n');
  });

  QUnit.test('services/telekom-http.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'services/telekom-http.js should pass ESLint\n\n');
  });
});
define('up-signal/tests/helpers/destroy-app', ['exports'], function (exports) {
  'use strict';

  Object.defineProperty(exports, "__esModule", {
    value: true
  });
  exports.default = destroyApp;
  function destroyApp(application) {
    Ember.run(application, 'destroy');
  }
});
define('up-signal/tests/helpers/ember-simple-auth', ['exports', 'ember-simple-auth/authenticators/test'], function (exports, _test) {
  'use strict';

  Object.defineProperty(exports, "__esModule", {
    value: true
  });
  exports.authenticateSession = authenticateSession;
  exports.currentSession = currentSession;
  exports.invalidateSession = invalidateSession;


  var TEST_CONTAINER_KEY = 'authenticator:test';

  function ensureAuthenticator(app, container) {
    var authenticator = container.lookup(TEST_CONTAINER_KEY);
    if (!authenticator) {
      app.register(TEST_CONTAINER_KEY, _test.default);
    }
  }

  function authenticateSession(app, sessionData) {
    var container = app.__container__;

    var session = container.lookup('service:session');
    ensureAuthenticator(app, container);
    session.authenticate(TEST_CONTAINER_KEY, sessionData);
    return app.testHelpers.wait();
  }

  function currentSession(app) {
    return app.__container__.lookup('service:session');
  }

  function invalidateSession(app) {
    var session = app.__container__.lookup('service:session');
    if (session.get('isAuthenticated')) {
      session.invalidate();
    }
    return app.testHelpers.wait();
  }
});
define('up-signal/tests/helpers/module-for-acceptance', ['exports', 'qunit', 'up-signal/tests/helpers/start-app', 'up-signal/tests/helpers/destroy-app'], function (exports, _qunit, _startApp, _destroyApp) {
  'use strict';

  Object.defineProperty(exports, "__esModule", {
    value: true
  });

  exports.default = function (name) {
    var options = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : {};

    (0, _qunit.module)(name, {
      beforeEach: function beforeEach() {
        this.application = (0, _startApp.default)();

        if (options.beforeEach) {
          return options.beforeEach.apply(this, arguments);
        }
      },
      afterEach: function afterEach() {
        var _this = this;

        var afterEach = options.afterEach && options.afterEach.apply(this, arguments);
        return resolve(afterEach).then(function () {
          return (0, _destroyApp.default)(_this.application);
        });
      }
    });
  };

  var resolve = Ember.RSVP.resolve;
});
define('up-signal/tests/helpers/resolver', ['exports', 'up-signal/resolver', 'up-signal/config/environment'], function (exports, _resolver, _environment) {
  'use strict';

  Object.defineProperty(exports, "__esModule", {
    value: true
  });


  var resolver = _resolver.default.create();

  resolver.namespace = {
    modulePrefix: _environment.default.modulePrefix,
    podModulePrefix: _environment.default.podModulePrefix
  };

  exports.default = resolver;
});
define('up-signal/tests/helpers/start-app', ['exports', 'up-signal/app', 'up-signal/config/environment'], function (exports, _app, _environment) {
  'use strict';

  Object.defineProperty(exports, "__esModule", {
    value: true
  });
  exports.default = startApp;
  function startApp(attrs) {
    var attributes = Ember.merge({}, _environment.default.APP);
    attributes = Ember.merge(attributes, attrs); // use defaults, but you can override;

    return Ember.run(function () {
      var application = _app.default.create(attributes);
      application.setupForTesting();
      application.injectTestHelpers();
      return application;
    });
  }
});
define('up-signal/tests/integration/components/create-contract-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleForComponent)('create-contract', 'Integration | Component | create contract', {
    integration: true
  });

  (0, _emberQunit.test)('it renders', function (assert) {

    // Set any properties with this.set('myProperty', 'value');
    // Handle any actions with this.on('myAction', function(val) { ... });

    this.render(Ember.HTMLBars.template({
      "id": "El3p0BbU",
      "block": "{\"statements\":[[1,[26,[\"create-contract\"]],false]],\"locals\":[],\"named\":[],\"yields\":[],\"hasPartials\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), '');

    // Template block usage:
    this.render(Ember.HTMLBars.template({
      "id": "QFk193lT",
      "block": "{\"statements\":[[0,\"\\n\"],[6,[\"create-contract\"],null,null,{\"statements\":[[0,\"      template block text\\n\"]],\"locals\":[]},null],[0,\"  \"]],\"locals\":[],\"named\":[],\"yields\":[],\"hasPartials\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), 'template block text');
  });
});
define('up-signal/tests/integration/components/info-list-item-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleForComponent)('info-list-item', 'Integration | Component | info list item', {
    integration: true
  });

  (0, _emberQunit.test)('it renders', function (assert) {

    // Set any properties with this.set('myProperty', 'value');
    // Handle any actions with this.on('myAction', function(val) { ... });

    this.render(Ember.HTMLBars.template({
      "id": "aYhRnOa3",
      "block": "{\"statements\":[[1,[26,[\"info-list-item\"]],false]],\"locals\":[],\"named\":[],\"yields\":[],\"hasPartials\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), '');

    // Template block usage:
    this.render(Ember.HTMLBars.template({
      "id": "gbp3JGcg",
      "block": "{\"statements\":[[0,\"\\n\"],[6,[\"info-list-item\"],null,null,{\"statements\":[[0,\"      template block text\\n\"]],\"locals\":[]},null],[0,\"  \"]],\"locals\":[],\"named\":[],\"yields\":[],\"hasPartials\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), 'template block text');
  });
});
define('up-signal/tests/integration/components/main-navigation-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleForComponent)('main-navigation', 'Integration | Component | main navigation', {
    integration: true
  });

  (0, _emberQunit.test)('it renders', function (assert) {

    // Set any properties with this.set('myProperty', 'value');
    // Handle any actions with this.on('myAction', function(val) { ... });

    this.render(Ember.HTMLBars.template({
      "id": "hpjcSeuV",
      "block": "{\"statements\":[[1,[26,[\"main-navigation\"]],false]],\"locals\":[],\"named\":[],\"yields\":[],\"hasPartials\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), '');

    // Template block usage:
    this.render(Ember.HTMLBars.template({
      "id": "1XaQLloK",
      "block": "{\"statements\":[[0,\"\\n\"],[6,[\"main-navigation\"],null,null,{\"statements\":[[0,\"      template block text\\n\"]],\"locals\":[]},null],[0,\"  \"]],\"locals\":[],\"named\":[],\"yields\":[],\"hasPartials\":false}",
      "meta": {}
    }));

    assert.equal(this.$().text().trim(), 'template block text');
  });
});
define('up-signal/tests/test-helper', ['up-signal/tests/helpers/resolver', 'ember-qunit', 'ember-cli-qunit'], function (_resolver, _emberQunit, _emberCliQunit) {
  'use strict';

  (0, _emberQunit.setResolver)(_resolver.default);
  (0, _emberCliQunit.start)();
});
define('up-signal/tests/tests.lint-test', [], function () {
  'use strict';

  QUnit.module('ESLint | tests');

  QUnit.test('helpers/destroy-app.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/destroy-app.js should pass ESLint\n\n');
  });

  QUnit.test('helpers/module-for-acceptance.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/module-for-acceptance.js should pass ESLint\n\n');
  });

  QUnit.test('helpers/resolver.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/resolver.js should pass ESLint\n\n');
  });

  QUnit.test('helpers/start-app.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'helpers/start-app.js should pass ESLint\n\n');
  });

  QUnit.test('integration/components/create-contract-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/components/create-contract-test.js should pass ESLint\n\n');
  });

  QUnit.test('integration/components/info-list-item-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/components/info-list-item-test.js should pass ESLint\n\n');
  });

  QUnit.test('integration/components/main-navigation-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'integration/components/main-navigation-test.js should pass ESLint\n\n');
  });

  QUnit.test('test-helper.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'test-helper.js should pass ESLint\n\n');
  });

  QUnit.test('unit/controllers/login-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/controllers/login-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/controllers/new-service-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/controllers/new-service-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/controllers/new-supplier-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/controllers/new-supplier-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/about-us-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/about-us-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/all-services-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/all-services-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/all-suppliers-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/all-suppliers-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/homepage-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/homepage-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/index-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/index-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/login-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/login-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/new-contract-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/new-contract-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/new-service-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/new-service-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/new-supplier-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/new-supplier-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/news-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/news-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/packages-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/packages-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/services-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/services-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/routes/suppliers-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/routes/suppliers-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/services/base-http-service-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/services/base-http-service-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/services/contract-service-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/services/contract-service-test.js should pass ESLint\n\n');
  });

  QUnit.test('unit/services/suppliers-service-test.js', function (assert) {
    assert.expect(1);
    assert.ok(true, 'unit/services/suppliers-service-test.js should pass ESLint\n\n');
  });
});
define('up-signal/tests/unit/controllers/login-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('controller:login', 'Unit | Controller | login', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it exists', function (assert) {
    var controller = this.subject();
    assert.ok(controller);
  });
});
define('up-signal/tests/unit/controllers/new-service-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('controller:new-service', 'Unit | Controller | new service', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it exists', function (assert) {
    var controller = this.subject();
    assert.ok(controller);
  });
});
define('up-signal/tests/unit/controllers/new-supplier-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('controller:new-supplier', 'Unit | Controller | new supplier', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it exists', function (assert) {
    var controller = this.subject();
    assert.ok(controller);
  });
});
define('up-signal/tests/unit/routes/about-us-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:about-us', 'Unit | Route | about us', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('up-signal/tests/unit/routes/all-services-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:all-services', 'Unit | Route | all services', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('up-signal/tests/unit/routes/all-suppliers-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:all-suppliers', 'Unit | Route | all suppliers', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('up-signal/tests/unit/routes/homepage-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:homepage', 'Unit | Route | homepage', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('up-signal/tests/unit/routes/index-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:index', 'Unit | Route | index', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('up-signal/tests/unit/routes/login-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:login', 'Unit | Route | login', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('up-signal/tests/unit/routes/new-contract-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:new-contract', 'Unit | Route | new contract', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('up-signal/tests/unit/routes/new-service-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:new-service', 'Unit | Route | new service', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('up-signal/tests/unit/routes/new-supplier-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:new-supplier', 'Unit | Route | new supplier', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('up-signal/tests/unit/routes/news-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:news', 'Unit | Route | news', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('up-signal/tests/unit/routes/packages-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:packages', 'Unit | Route | packages', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('up-signal/tests/unit/routes/services-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:services', 'Unit | Route | services', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('up-signal/tests/unit/routes/suppliers-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('route:suppliers', 'Unit | Route | suppliers', {
    // Specify the other units that are required for this test.
    // needs: ['controller:foo']
  });

  (0, _emberQunit.test)('it exists', function (assert) {
    var route = this.subject();
    assert.ok(route);
  });
});
define('up-signal/tests/unit/services/base-http-service-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('service:base-http-service', 'Unit | Service | base http service', {
    // Specify the other units that are required for this test.
    // needs: ['service:foo']
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it exists', function (assert) {
    var service = this.subject();
    assert.ok(service);
  });
});
define('up-signal/tests/unit/services/contract-service-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('service:contract-service', 'Unit | Service | contract service', {
    // Specify the other units that are required for this test.
    // needs: ['service:foo']
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it exists', function (assert) {
    var service = this.subject();
    assert.ok(service);
  });
});
define('up-signal/tests/unit/services/suppliers-service-test', ['ember-qunit'], function (_emberQunit) {
  'use strict';

  (0, _emberQunit.moduleFor)('service:suppliers-service', 'Unit | Service | suppliers service', {
    // Specify the other units that are required for this test.
    // needs: ['service:foo']
  });

  // Replace this with your real tests.
  (0, _emberQunit.test)('it exists', function (assert) {
    var service = this.subject();
    assert.ok(service);
  });
});
require('up-signal/tests/test-helper');
EmberENV.TESTS_FILE_LOADED = true;
//# sourceMappingURL=tests.map
