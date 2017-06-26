package com.afocus.pbuilder.common.context;

import com.afocus.pbuilder.common.utils.NamedList;

public interface Bean<T extends Field> extends Named, Commented, Alias,
		Original, NamedList<T> {

}
