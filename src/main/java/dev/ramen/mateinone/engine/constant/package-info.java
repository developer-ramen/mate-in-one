/**
 * <p>
 *     Provides enumeration classes that contain information about or related to a chess piece.
 *     There are 4 enumerations for different fields of a chess piece:
 *     <ul>
 *         <li>
 *             {@link dev.ramen.mateinone.engine.constant.Identifier}
 *             The unique character that dictates a chess piece's identity.
 *             May also be used as a representation.
 *         </li>
 *         <li>{@link dev.ramen.mateinone.engine.constant.Representation}
 *              The Unicode characters that represent a chess piece, or otherwise a Swing-compatible image.
 *         </li>
 *         <li>
 *             {@link dev.ramen.mateinone.engine.constant.Color}
 *             The color that a chess piece is, or semantically represents a chess game's outcome.
 *         </li>
 *         <li>
 *             {@link dev.ramen.mateinone.engine.constant.Direction}
 *             The direction that a chess piece can move in. This is purely for semantic purposes,
 *             and for better interpreting of the formal rules of chess.
 *         </li>
 *         <li>
 *             {@link dev.ramen.mateinone.engine.constant.MoveType}
 *             The type of the move that a chess piece can make. This is also for semantic purposes.
 *         </li>
 *     </ul>
 * </p>
 */
package dev.ramen.mateinone.engine.constant;