/*
 * Copyright © 2017 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

import PropTypes from 'prop-types';

import React from 'react';
import classNames from 'classnames';

const CustomDropdownMenu = (props, context) => {
  let { className, right, children, tag: Tag } = props;
  const classes = classNames(className, 'dropdown-menu', { 'dropdown-menu-right': right });
  Tag = Tag || 'ul';
  return (
    <Tag tabIndex="-1" aria-hidden={!context.isOpen} role="menu" className={classes}>
      {children}
    </Tag>
  );
};

CustomDropdownMenu.propTypes = {
  children: PropTypes.node.isRequired,
  right: PropTypes.bool,
  className: PropTypes.string,
  cssModule: PropTypes.object,
  tag: PropTypes.oneOfType([PropTypes.func, PropTypes.string]),
};
CustomDropdownMenu.contextTypes = {
  isOpen: PropTypes.bool.isRequired,
  right: PropTypes.bool,
};

export default CustomDropdownMenu;
