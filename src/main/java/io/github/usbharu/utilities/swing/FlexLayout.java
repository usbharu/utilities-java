/*
 * Copyright 2022 usbharu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.usbharu.utilities.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class FlexLayout implements LayoutManager {


  public static final int HORIZONTAL = 0;
  public static final int VERTICAL = 1;

  private int direction = HORIZONTAL;

  private int cellWidth;
  private int cellHeight;
  private int hgap;
  private int vgap;

  public FlexLayout() {
    this(HORIZONTAL);
  }

  public FlexLayout(int direction) {
    this(direction, 100, 100);
  }

  public FlexLayout(int direction, int cellWidth, int cellHeight) {
    this(direction, cellWidth, cellHeight, 0, 0);
  }

  public FlexLayout(int direction, int cellWidth, int cellHeight, int hgap, int vgap) {
    if (direction != HORIZONTAL && direction != VERTICAL) {
      throw new IllegalArgumentException("direction must be either HORIZONTAL or VERTICAL");
    }
    this.direction = direction;
    this.cellHeight = cellHeight;
    this.cellWidth = cellWidth;
    this.hgap = hgap;
    this.vgap = vgap;
  }

  @Override
  public void addLayoutComponent(String name, Component comp) {

  }

  @Override
  public void removeLayoutComponent(Component comp) {

  }

  @Override
  public Dimension preferredLayoutSize(Container parent) {
    return minimumLayoutSize(parent);
  }

  @Override
  public Dimension minimumLayoutSize(Container parent) {
    final int componentCount = parent.getComponentCount();
    if (componentCount == 0) {
      return new Dimension(0, 0);
    }
    int numRows = 0;
    int numCols = 0;
    if (direction == HORIZONTAL) {
      numCols = Math.max(1, parent.getSize().width / cellWidth);
      numRows = componentCount / numCols;
    } else if (direction == VERTICAL) {
      numRows = parent.getSize().height / cellHeight;
      numCols = componentCount / numRows;
    }
    return new Dimension(numCols * cellWidth + (numCols - 1) * hgap,
        numRows * cellHeight + (numRows - 1) * vgap);
  }


  @Override
  public void layoutContainer(Container parent) {
    final int componentCount = parent.getComponentCount();
    System.out.println(componentCount);
    if (componentCount == 0) {
      return;
    }
    int numRows = 1;
    int numCols = 1;
    Dimension size = parent.getSize();
    System.out.println(size);
    if (direction == HORIZONTAL) {
      numCols = Math.max(1, size.width / cellWidth);
      numRows = Math.max(1, componentCount / numCols + (componentCount % numCols == 0 ? 0 : 1));
    } else if (direction == VERTICAL) {
      numRows = Math.max(1, size.height / cellHeight);
      numCols = Math.max(1, componentCount / numRows + (componentCount % numRows == 0 ? 0 : 1));
    }
    System.out.println(numRows + " , " + numCols);
    int widthOffset = (size.width + hgap) / numCols - cellWidth - hgap;
    int heightOffset = (size.height + vgap) / numRows - cellHeight - vgap;
    widthOffset = Math.min(widthOffset, heightOffset);
    heightOffset = widthOffset;
    int col = 0;
    int row = 0;
    for (int i = 0; i < componentCount; i++) {
      Component c = parent.getComponent(i);
      System.out.println(row + " , " + col);
      c.setBounds(col * (cellWidth + widthOffset) + col * hgap,
          row * (cellHeight + heightOffset) + row * vgap, cellWidth + widthOffset,
          cellHeight + heightOffset);
      if (direction == HORIZONTAL) {
        col++;
        if (col == numCols) {
          col = 0;
          row++;
        }
      } else if (direction == VERTICAL) {
        row++;
        if (row == numRows) {
          row = 0;
          col++;
        }
      }
    }
  }
}
