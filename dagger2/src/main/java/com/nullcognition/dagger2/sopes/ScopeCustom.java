package com.nullcognition.dagger2.sopes;
// ersin 05/09/15 Copyright (c) 2015+ All rights reserved.

import javax.inject.Scope;

@Scope
public @interface ScopeCustom{
}

// custom scopes may only have one instance of dependency
// add semantic clarity
// added beside the @Provides @ScopeCustom
// in a module, and beside the @Component

// scopeing is good for composing the app such that
// modules are an implementation detail, what you expose
//

// this allows you to throw away components that are
// user specific, keeping vital components like networking,
// database, etc. and recreating a new component for the
// new user
